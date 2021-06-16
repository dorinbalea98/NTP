import { LOAD, LoadContent, LoadedContent } from 'src/content.action';

export type Action = LoadContent;

const newState = (state: LoadedContent[], newData: LoadedContent) => {
    return state.concat(newData);
}

export function contentReducer(state: LoadedContent[] = [], action: Action) {
    if(action.type === LOAD) {
        return newState(state, action.payload);
    }

}