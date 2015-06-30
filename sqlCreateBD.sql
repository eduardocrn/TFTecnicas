CREATE TABLE Usuarios (
idUsuario int PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
Nome varchar(50),
CpfCnpj varchar(15),
Email varchar(50)
);

CREATE TABLE Leiloes (
idLeilao int PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
DataInicio Date,
HoraInicio Time,
DataFim Date,
HoraFIm Time,
Natureza int,
FormaLance int,
ValorLote Decimal,
Usuario_id int
);

CREATE TABLE Bens (
idBem int PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
DescricaoBreve varchar(50),
DescricaoCompleta varchar(255),
Categoria_id int,
Leilao_id int
);

CREATE TABLE CategoriasBens (
idCategoria int PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
NomeCategoria varchar(50)
);

CREATE TABLE Lances (
idLance int PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
Data Date,
Hora Time,
Valor Decimal,
Usuario_id int,
Leilao_id int
);

ALTER TABLE Lances ADD CONSTRAINT fk_Lances_Usuarios 
FOREIGN KEY (Usuario_id) REFERENCES Usuarios(idUsuario);

ALTER TABLE Lances ADD CONSTRAINT fk_Lances_Leiloes 
FOREIGN KEY (Leilao_id) REFERENCES Leiloes(idLeilao);

ALTER TABLE Leiloes ADD CONSTRAINT fk_Leiloes_Usuarios 
FOREIGN KEY (Usuario_id) REFERENCES Usuarios(idUsuario);

ALTER TABLE Bens ADD CONSTRAINT fk_Bens_Categorias 
FOREIGN KEY (Categoria_id) REFERENCES CategoriasBens(idCategoria);

ALTER TABLE Bens ADD CONSTRAINT fk_Bens_Leiloes
FOREIGN KEY (Leilao_id) REFERENCES Leiloes(idLeilao);
