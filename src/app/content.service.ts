import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable, of } from 'rxjs';
import { LoadedContent } from 'src/content.action';
import { AppState } from './app.component';
import { Content } from './content.model';

@Injectable()
export class ContentService {

    private readonly url = "http://localhost:8080/api/";

    constructor(private readonly http: HttpClient) {
        }

    public getRoots(): Observable<Content[]> {
        return this.http.get<Content[]>(`${this.url}documents`);
    }

    public getChildren(id: number): Observable<Content[]> {
        return this.http.get<Content[]>(`${this.url}documents/${id}`);
    }

}