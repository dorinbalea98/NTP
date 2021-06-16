export interface Content {
    id: number;
    name: string;
    title: string;
    type: ContentType;
    mymetype?: string;
    url?: string;
    parentId: number;
}

export enum ContentType {
    FOLDER = "FOLDER",
    ASSET = "ASSET"
}