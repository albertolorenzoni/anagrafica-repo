export class Person {

    public idAnagrafica: number;
    public provincia: string;
    public comune: string;

    constructor(
        public nome: string,
        public cognome: string,
        public indirizzo: string,
        public numCivico: number,
        public idComune: number,
        public idProvincia: number
    ) {}
    
}
