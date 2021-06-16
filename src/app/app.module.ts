import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContentService } from './content.service';
import { TreeViewComponent } from './tree-view/tree-view.component';
import { StoreModule } from '@ngrx/store';
import { contentReducer } from './content.reducer';

@NgModule({
  declarations: [
    AppComponent,
    TreeViewComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    StoreModule.forRoot( {content: contentReducer})
  ],
  providers: [ContentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
