import { Action } from '@ngrx/store';
import { Content } from './app/content.model';

export const LOAD = "[Content] Loaded";

export interface LoadedContent {
    parentId: number;
    children: Content[];
}

export class LoadContent implements Action {
    readonly type = LOAD;
    constructor(public payload: LoadedContent) {}
}