export interface ITB_UBS {
    id?: number;
    co_latitude?: string;
    co_longitute?: string;
    co_municipio?: number;
    co_cnes?: number;
    no_estabelecimento?: string;
    no_endereco?: string;
    no_bairro?: string;
    no_cidade?: string;
    co_telefone?: string;
    no_estrutra_fisica_ambiencia?: string;
    no_adap_defic_fisic_idoso?: string;
    no_equipamentos?: string;
    no_medicamentos?: string;
}

export class TB_UBS implements ITB_UBS {
    constructor(
        public id?: number,
        public co_latitude?: string,
        public co_longitute?: string,
        public co_municipio?: number,
        public co_cnes?: number,
        public no_estabelecimento?: string,
        public no_endereco?: string,
        public no_bairro?: string,
        public no_cidade?: string,
        public co_telefone?: string,
        public no_estrutra_fisica_ambiencia?: string,
        public no_adap_defic_fisic_idoso?: string,
        public no_equipamentos?: string,
        public no_medicamentos?: string
    ) {}
}
