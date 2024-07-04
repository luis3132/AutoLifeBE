CREATE TABLE roles (
	id int not null auto_increment,
	rol varchar(20) not null,
	constraint roles_pk primary key (id)
);
CREATE TABLE usuarios (
	dni varchar(20) not null,
	nombre varchar(100) not null,
	apellidos varchar(100),
	telefono varchar(15),
	direccion varchar(200),
	roles int not null default "0",
	contrasena varchar(500) not null,
	constraint users_pk primary key (dni),
	constraint users_fk foreign key (roles) references roles (id) on delete no action on UPDATE no action
);
CREATE TABLE tipovehiculo (
	id int not null auto_increment,
	nombre varchar(50) not null,
	descripcion varchar(150),
	primary key (id)
);
CREATE TABLE vehiculo (
	num_serie varchar(200) not null,
	placa varchar(10),
	tipovehiculo int,
	marca varchar(50) not null,
	modelo varchar(50) not null,
	referencia varchar(50),
	serie varchar(50),
	color varchar(15),
	usuario varchar(20),
	kilometraje int not null,
	ciudad_procedencia varchar(50),
	primary key (num_serie),
	constraint vehiculo_fk foreign key (tipovehiculo) references tipovehiculo (id),
	constraint vehiculo_fk_1 foreign key (usuario) references usuarios (dni)
);
CREATE TABLE duenos (
	id bigint not null auto_increment,
	usuario varchar(20),
	vehiculo varchar(200),
	kmstart int,
	kmfinish int,
	datestart date,
	datefinish date,
	ciudadpromtransi varchar(50),
	primary key (id),
	constraint duenos_fk foreign key (usuario) references usuarios (dni),
	constraint duenos_fk_1 foreign key (vehiculo) references vehiculo (num_serie)
);
CREATE TABLE seguro (
	id varchar(250) not null,
	descripcion varchar(100),
	datestart date not null,
	datefinish date not null,
	vehiculo varchar(200) not null,
	primary key (id),
	constraint seguro_fk foreign key (vehiculo) references vehiculo (num_serie)
);
CREATE TABLE soat (
	id varchar(250) not null,
	descripcion varchar(100),
	datestart date not null,
	datefinish date not null,
	vehiculo varchar(200) not null,
	primary key (id),
	constraint soat_fk foreign key (vehiculo) references vehiculo (num_serie)
);
CREATE TABLE tecnicomecanica (
	id varchar(250) not null,
	descripcion varchar(100),
	kilometraje int not null,
	datestart date not null,
	datefinish date not null,
	vehiculo varchar(200) not null,
	primary key (id),
	constraint tecnicomecanica_fk foreign key (vehiculo) references vehiculo (num_serie)
);
CREATE TABLE accidentes (
	id varchar(250) not null,
	fechaaccidente date not null,
	descripcion varchar(300),
	coordenadas varchar(20),
	costototalestimadodanos double,
	primary key (id)
);
CREATE TABLE vehimplicados (
	accidentes varchar(250),
	vehiculo varchar(200),
	piezas_afectadas varchar(1500),
	costoestimadoreparacion double,
	primary key (accidentes, vehiculo),
	constraint vehimplicados_fk foreign key (accidentes) references accidentes (id),
	constraint vehimplicados_fk_1 foreign key (vehiculo) references vehiculo (num_serie)
);
CREATE TABLE mantenimiento (
	id varchar(300) not null,
	fechamantenimiento date not null,
	fechaaproxmantenimiento date,
	tipomantenimiento varchar(50),
	costomantenimiento double,
	descripcion varchar(500),
	kilometraje int,
	vehiculo varchar(200),
	tecnicomecanica varchar(250),
	primary key (id),
	constraint mantenimiento_fk foreign key (vehiculo) references vehiculo (num_serie),
	constraint mantenimiento_fk_1 foreign key (tecnicomecanica) references tecnicomecanica (id)
);
CREATE TABLE reparacion (
	id varchar(300) not null,
	fechareparacion date not null,
	tiporeparacion varchar(50),
	costoreparacion double,
	descripcion varchar(500),
	kilometraje int,
	vehiculo varchar(200),
	tecnicomecanica varchar(250),
	primary key (id),
	constraint reparacion_fk foreign key (vehiculo) references vehiculo (num_serie),
	constraint reparacion_fk_1 foreign key (tecnicomecanica) references tecnicomecanica (id)
);
CREATE TABLE modificacion (
	id varchar(300) not null,
	fechamodificacion date not null,
	tipomodificacion varchar(50),
	costomodificaion double,
	descripcion varchar(500),
	kilometraje int,
	vehiculo varchar(200),
	primary key (id),
	constraint modificacion_fk foreign key (vehiculo) references vehiculo (num_serie)
);
CREATE TABLE piezas (
	id varchar(150) not null,
	pieza bigint not null,
	mantenimiento varchar(300),
	reparacion varchar(300),
	modificacion varchar(300),
	primary key (id),
	constraint piezas_fk foreign key (mantenimiento) references mantenimiento (id),
	constraint piezas_fk_1 foreign key (reparacion) references reparacion (id),
	constraint piezas_fk_2 foreign key (modificacion) references modificacion (id)
);
CREATE TABLE fotos (
	id varchar(500) not null,
	foto varchar(200) not null,
	vehiculo varchar(200),
	modificacion varchar(300),
	reparacion varchar(300),
	mantenimiento varchar(300),
	accidentes varchar(250),
	usuarios varchar(20),
	soat varchar(250),
	seguro varchar(250),
	tecnicomecanica varchar(250),
	piezas bigint,
	partes bigint,
	primary key (id),
	constraint fotos_fk foreign key (vehiculo) references vehiculo (num_serie),
	constraint fotos_fk_1 foreign key (modificacion) references modificacion (id),
	constraint fotos_fk_2 foreign key (reparacion) references reparacion (id),
	constraint fotos_fk_3 foreign key (mantenimiento) references mantenimiento (id),
	constraint fotos_fk_4 foreign key (accidentes) references accidentes (id),
	constraint fotos_fk_5 foreign key (usuarios) references usuarios (dni),
	constraint fotos_fk_6 foreign key (soat) references soat (id),
	constraint fotos_fk_7 foreign key (seguro) references seguro (id),
	constraint fotos_fk_8 foreign key (tecnicomecanica) references tecnicomecanica (id)
);
ALTER TABLE AutoLife.accidentes MODIFY COLUMN costototalestimadodanos DOUBLE NULL;
ALTER TABLE AutoLife.usuarios ADD email varchar(150) NOT NULL;
ALTER TABLE AutoLife.usuarios ADD nombre_usuario varchar(20) NOT NULL;
ALTER TABLE AutoLife.usuarios MODIFY COLUMN email varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci unique NOT NULL;
ALTER TABLE AutoLife.usuarios MODIFY COLUMN nombre_usuario varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci UNIQUE  NOT NULL;
ALTER TABLE AutoLife.usuarios MODIFY COLUMN roles int DEFAULT 2 NOT NULL;
ALTER TABLE AutoLife.vehiculo ADD publico BOOL NOT NULL;
ALTER TABLE AutoLife.vehiculo ADD descripcion varchar(1000) NULL;
ALTER TABLE AutoLife.fotos DROP FOREIGN KEY fotos_fk_4;
ALTER TABLE AutoLife.fotos ADD CONSTRAINT fotos_fk_4 FOREIGN KEY (accidentes) REFERENCES AutoLife.accidentes(id) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE AutoLife.fotos DROP FOREIGN KEY fotos_fk_3;
ALTER TABLE AutoLife.fotos ADD CONSTRAINT fotos_fk_3 FOREIGN KEY (mantenimiento) REFERENCES AutoLife.mantenimiento(id) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE AutoLife.fotos DROP FOREIGN KEY fotos_fk_1;
ALTER TABLE AutoLife.fotos ADD CONSTRAINT fotos_fk_1 FOREIGN KEY (modificacion) REFERENCES AutoLife.modificacion(id) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE AutoLife.fotos DROP FOREIGN KEY fotos_fk_2;
ALTER TABLE AutoLife.fotos ADD CONSTRAINT fotos_fk_2 FOREIGN KEY (reparacion) REFERENCES AutoLife.reparacion(id) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE AutoLife.fotos DROP FOREIGN KEY fotos_fk_7;
ALTER TABLE AutoLife.fotos ADD CONSTRAINT fotos_fk_7 FOREIGN KEY (seguro) REFERENCES AutoLife.seguro(id) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE AutoLife.fotos DROP FOREIGN KEY fotos_fk_6;
ALTER TABLE AutoLife.fotos ADD CONSTRAINT fotos_fk_6 FOREIGN KEY (soat) REFERENCES AutoLife.soat(id) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE AutoLife.fotos DROP FOREIGN KEY fotos_fk_8;
ALTER TABLE AutoLife.fotos ADD CONSTRAINT fotos_fk_8 FOREIGN KEY (tecnicomecanica) REFERENCES AutoLife.tecnicomecanica(id) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE AutoLife.fotos DROP FOREIGN KEY fotos_fk_5;
ALTER TABLE AutoLife.fotos ADD CONSTRAINT fotos_fk_5 FOREIGN KEY (usuarios) REFERENCES AutoLife.usuarios(dni) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE AutoLife.fotos DROP FOREIGN KEY fotos_fk;
ALTER TABLE AutoLife.fotos ADD CONSTRAINT fotos_fk FOREIGN KEY (vehiculo) REFERENCES AutoLife.vehiculo(num_serie) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE AutoLife.fotos MODIFY COLUMN id varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL;
ALTER TABLE AutoLife.fotos MODIFY COLUMN foto varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL;
ALTER TABLE AutoLife.accidentes ADD publico TINYINT(1) NOT NULL;







INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('sedan', 'Vehículo de turismo con carrocería de tres volúmenes: motor, habitáculo y maletero');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('pickup', 'Vehículo con cabina cerrada y área de carga abierta');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('SUV', 'Vehículo utilitario deportivo con características de todoterreno');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('coupe', 'Vehículo de dos puertas y techo inclinado, generalmente deportivo');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('hatchback', 'Vehículo con puerta trasera que se abre hacia arriba para acceder al maletero');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('convertible', 'Vehículo con un techo plegable o desmontable');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('minivan', 'Vehículo grande y espacioso, ideal para familias');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('van', 'Vehículo grande utilizado para transporte de mercancías o pasajeros');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('wagon', 'Vehículo con un área de carga extendida y una puerta trasera');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('crossover', 'Vehículo que combina características de SUV y coche compacto');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('roadster', 'Vehículo deportivo de dos asientos y techo descubierto');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('electric', 'Vehículo propulsado por uno o más motores eléctricos');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('hybrid', 'Vehículo que combina un motor de combustión interna con uno o más motores eléctricos');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('luxury', 'Vehículo de alta gama con características premium y mayor confort');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('sports car', 'Vehículo diseñado para altas prestaciones y velocidad');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('compact', 'Vehículo de tamaño reducido, ideal para ciudad');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('Motocicleta', 'Vehículo de dos ruedas motorizado');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('ATV', 'Vehículo todo terreno utilizado para actividades recreativas o laborales');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('bus', 'Vehículo grande diseñado para transportar muchos pasajeros');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('truck', 'Vehículo diseñado para transportar mercancías pesadas');

INSERT INTO AutoLife.tipovehiculo (nombre, descripcion)
VALUES('limousine', 'Vehículo de lujo con un compartimento separado para el conductor y pasajeros');

INSERT INTO AutoLife.roles (rol)
VALUES('Admin');

INSERT INTO AutoLife.roles (rol)
VALUES('User');
