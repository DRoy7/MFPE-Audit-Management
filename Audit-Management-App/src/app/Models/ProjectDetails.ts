export class ProjectDetails{
    constructor(
        private _name : string,
        private _projectName : string,
        private _valid : boolean
    ){}

    public get name() : string{
        return this._name;
    }

    public get projectName() : string{
        return this._projectName;
    }

    public get valid() : boolean{
        return this._valid;
    }
}