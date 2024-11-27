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
	roles int not null default 2,
	contrasena varchar(500) not null,
	email varchar(150) not null unique,
	nombre_usuario varchar(20) NOT NULL unique,
	estado varchar(20),
	constraint users_pk primary key (dni),
	constraint users_fk foreign key (roles) references roles (id) ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE tipo_vehiculo (
	id int not null auto_increment,
	nombre varchar(50) not null,
	descripcion varchar(150),
	constraint tipo_vehiculo_pk primary key (id)
);
CREATE TABLE vehiculo (
	num_serie varchar(30) not null,
	placa varchar(10) unique,
	tipo_vehiculo int not null,
	marca varchar(50) not null,
	modelo varchar(50) not null,
	referencia varchar(50),
	serie varchar(50),
	color varchar(15),
	usuario varchar(20) not null,
	kilometraje int not null,
	ciudad_procedencia varchar(50),
	publico bool not null,
	descripcion varchar(300),
	constraint vehiculo_pk primary key (num_serie),
	constraint vehiculo_fk foreign key (tipo_vehiculo) references tipo_vehiculo (id) ON UPDATE NO ACTION ON DELETE NO ACTION,
	constraint vehiculo_fk_1 foreign key (usuario) references usuarios (dni) ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE duenos (
	usuario varchar(20),
	vehiculo varchar(30),
	kmstart int,
	kmfinish int,
	datestart date,
	datefinish date,
	ciudadpromtransi varchar(50),
	constraint duenos_pk primary key (usuario, vehiculo),
	constraint duenos_fk foreign key (usuario) references usuarios (dni) ON UPDATE NO ACTION ON DELETE NO ACTION,
	constraint duenos_fk_1 foreign key (vehiculo) references vehiculo (num_serie) ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE tipo_legislacion (
	id int not null auto_increment,
	legislacion varchar(20) not null,
	constraint tipo_legislacion_pk primary key (id)
);
CREATE TABLE legislacion (
	id BigInt not null auto_increment,
	descripcion varchar(250),
	date_start date not null,
	date_finish date not null,
	vehiculo varchar(30) not null,
	kilometraje int not null,
	tipo_legislacion int not null,
	constraint legislacion_pk primary key (id),
	constraint legislacion_fk foreign key (vehiculo) references vehiculo (num_serie) ON UPDATE NO ACTION ON DELETE NO ACTION,
	constraint legislacion_fk_1 foreign key (tipo_legislacion) references tipo_legislacion (id) ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE accidentes (
	id BigInt not null auto_increment,
	fechaaccidente date not null,
	descripcion varchar(300),
	coordenadas varchar(20),
	costototalestimadodanos double,
	publico bool not null,
	constraint accidentes_pk primary key (id)
);
CREATE TABLE vehiculos_implicados (
	accidentes BigInt,
	vehiculo varchar(200),
	piezas_afectadas varchar(1500),
	costoestimadoreparacion double,
	constraint vehiculos_implicados_pk primary key (accidentes, vehiculo),
	constraint vehimplicados_fk foreign key (accidentes) references accidentes (id),
	constraint vehimplicados_fk_1 foreign key (vehiculo) references vehiculo (num_serie)
);
CREATE TABLE tipo_servicio (
	id int not null auto_increment,
	servicio varchar(20) not null,
	constraint tipo_servicio_pk primary key (id)
);
CREATE TABLE servicios (
	id BigInt not null auto_increment,
	fecha datetime not null,
	fecha_proximo date,
	tipo_servicio int not null,
	costo_servicio double,
	descripcion varchar(500),
	kilometraje int not null,
	vehiculo varchar(30) not null,
	usuario varchar(20) not null,
	mecanico varchar(20) not null,
	constraint servicios_pk primary key (id),
	constraint servicios_fk foreign key (tipo_servicio) references tipo_servicio (id) ON UPDATE NO ACTION ON DELETE NO ACTION,
	constraint servicios_fk_1 foreign key (vehiculo) references vehiculo (num_serie) ON UPDATE NO ACTION ON DELETE NO ACTION,
	constraint servicion_fk_2 foreign key (mecanico) references usuarios (dni) ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE piezas (
	id varchar(150) not null,
	pieza bigint not null,
	servicio BigInt,
	constraint piezas_pk primary key (id),
	constraint piezas_fk foreign key (servicio) references servicios (id) ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE fotos (
	id BigInt not null auto_increment,
	path varchar(200) not null,
	vehiculo varchar(200),
	servicio BigInt,
	accidentes BigInt,
	usuarios varchar(20),
	legislacion BigInt,
	piezas bigint,
	partes bigint,
	constraint fotos_pk primary key (id),
	constraint fotos_fk foreign key (vehiculo) references vehiculo (num_serie) ON UPDATE NO ACTION ON DELETE CASCADE,
	constraint fotos_fk_1 foreign key (servicio) references servicios (id) ON UPDATE NO ACTION ON DELETE CASCADE,
	constraint fotos_fk_2 foreign key (legislacion) references legislacion (id) ON UPDATE NO ACTION ON DELETE CASCADE,
	constraint fotos_fk_4 foreign key (accidentes) references accidentes (id) ON UPDATE NO ACTION ON DELETE CASCADE,
	constraint fotos_fk_5 foreign key (usuarios) references usuarios (dni) ON UPDATE NO ACTION ON DELETE CASCADE
);
CREATE TABLE notificaciones (
	id BigInt not null auto_increment,
	texto varchar(500) not null,
	estado varchar(20) not null,
	usuario varchar(20) not null,
	vehiculo varchar(30) not null,
	servicio BigInt not null,
	fecha Date not null,
	taller varchar(20) not null,
	constraint notificaciones_pk primary key (id),
	constraint notificaciones_fk foreign key (usuario) references usuarios (dni) ON UPDATE NO ACTION ON DELETE CASCADE,
	constraint notificaciones_fk_1 foreign key (vehiculo) references vehiculo (num_serie) ON UPDATE NO ACTION ON DELETE CASCADE,
	constraint notificaciones_fk_2 foreign key (servicio) references servicios (id) ON UPDATE NO ACTION ON DELETE CASCADE
);

# ALTER TABLE tipo_vehiculo AUTO_INCREMENT = 1;


INSERT INTO AutoLife.tipo_servicio (servicio)
VALUES('Mantenimiento');

INSERT INTO AutoLife.tipo_servicio (servicio)
VALUES('Modificacion');

INSERT INTO AutoLife.tipo_servicio (servicio)
VALUES('Reparacion');

INSERT INTO AutoLife.tipo_legislacion (legislacion)
VALUES('SOAT');

INSERT INTO AutoLife.tipo_legislacion (legislacion)
VALUES('Tecnico Mecanica');

INSERT INTO AutoLife.tipo_legislacion (legislacion)
VALUES('Seguro');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('sedan', 'Vehículo de turismo con carrocería de tres volúmenes: motor, habitáculo y maletero');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('pickup', 'Vehículo con cabina cerrada y área de carga abierta');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('SUV', 'Vehículo utilitario deportivo con características de todoterreno');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('coupe', 'Vehículo de dos puertas y techo inclinado, generalmente deportivo');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('hatchback', 'Vehículo con puerta trasera que se abre hacia arriba para acceder al maletero');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('convertible', 'Vehículo con un techo plegable o desmontable');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('minivan', 'Vehículo grande y espacioso, ideal para familias');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('van', 'Vehículo grande utilizado para transporte de mercancías o pasajeros');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('wagon', 'Vehículo con un área de carga extendida y una puerta trasera');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('crossover', 'Vehículo que combina características de SUV y coche compacto');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('roadster', 'Vehículo deportivo de dos asientos y techo descubierto');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('electric', 'Vehículo propulsado por uno o más motores eléctricos');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('hybrid', 'Vehículo que combina un motor de combustión interna con uno o más motores eléctricos');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('luxury', 'Vehículo de alta gama con características premium y mayor confort');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('sports car', 'Vehículo diseñado para altas prestaciones y velocidad');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('compact', 'Vehículo de tamaño reducido, ideal para ciudad');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('Motocicleta', 'Vehículo de dos ruedas motorizado');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('ATV', 'Vehículo todo terreno utilizado para actividades recreativas o laborales');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('bus', 'Vehículo grande diseñado para transportar muchos pasajeros');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('truck', 'Vehículo diseñado para transportar mercancías pesadas');

INSERT INTO AutoLife.tipo_vehiculo (nombre, descripcion)
VALUES('limousine', 'Vehículo de lujo con un compartimento separado para el conductor y pasajeros');

INSERT INTO AutoLife.roles (rol)
VALUES('ADMIN');

INSERT INTO AutoLife.roles (rol)
VALUES('USER');

INSERT INTO AutoLife.roles (rol)
VALUES('TALLER');