export class SecurityToken{
    constructor(
        private _jwt : string
    ){}

    public get jwt() : string{
        return this._jwt;
    }

    
    // public set jwt(jwt : string) { may be setters are not required...lets check
    //     this._jwt = jwt;
    // }
    
}