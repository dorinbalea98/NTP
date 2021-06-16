import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { Store } from '@ngrx/store';
import { LoadContent, LoadedContent } from 'src/content.action';
import { Content, ContentType } from './content.model';
import { ContentService } from './content.service';

export interface AppState {
  content: LoadedContent[];
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  data: Content[];
  roots: Content[];
  showAsset = false;
  url;
  cardView = true;
  state: LoadedContent[] = [];
  dataHistory: number[] = [];

  constructor(
    private readonly store: Store<AppState>,
    private readonly contentService: ContentService,
    private readonly sanitizer: DomSanitizer) {}

  ngOnInit() {
    this.contentService.getRoots().subscribe(roots => { this.data = roots; this.roots = roots });
    this.contentService.getChildren(1).subscribe(b => {this.store.dispatch(new LoadContent({parentId: 1, children: b}))});
    this.store.select('content').subscribe(state => this.state = state);
  }

  clicked(item: Content) {
    if (item.type === ContentType.FOLDER) {
      const stateItem = this.state.find(it => it.parentId === item.id);
      if (stateItem) {
        this.data = stateItem.children;
      } else {
        this.contentService.getChildren(item.id)
          .subscribe(children => {
            this.store.dispatch(new LoadContent({ parentId: item.id, children }));
            this.data = children;
          });

      }
      if (item.parentId) {
        this.dataHistory.push(item.parentId);
      }
    } else {
      this.showAsset = true;
      this.url = this.sanitizer.bypassSecurityTrustResourceUrl(item.url);
    }

  }

  back() {
    console.log(this.dataHistory);
    if(this.dataHistory.length > 0) {
      this.data = this.state.find(el => el.parentId === this.dataHistory[this.dataHistory.length - 1]).children;
      this.dataHistory.pop();
    } else {
      this.data = this.roots;
    }
  }

}
