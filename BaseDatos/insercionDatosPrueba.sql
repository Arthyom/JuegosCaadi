INSERT INTO `mydb`.`Usuario` (`Usuario_Clase`, `Usuario_Nombre`, `Usuario_Apellidos`, `Usuario_Grado`, `Usuario_Password`, `Usuario_Activo`) VALUES ('administrador', 'isabel', 'rosa', 'maestria', '1234', '1');
INSERT INTO `mydb`.`Usuario` (`Usuario_Clase`, `Usuario_Nombre`, `Usuario_Apellidos`, `Usuario_Grado`, `Usuario_Password`, `Usuario_Activo`) VALUES ('EstudianteLei', 'raquel', 'zavala', 'estudiante', '5678', '0');
INSERT INTO `mydb`.`Usuario` (`Usuario_Clase`, `Usuario_Nombre`, `Usuario_Apellidos`, `Usuario_Grado`, `Usuario_Password`, `Usuario_Activo`) VALUES ('profesor', 'rodolfo', 'garcia', 'profesor', '9101', '0');
INSERT INTO `mydb`.`Usuario` (`Usuario_Clase`, `Usuario_Nombre`, `Usuario_Apellidos`, `Usuario_Grado`, `Usuario_Password`, `Usuario_Activo`) VALUES ('EstudianteSimple', 'carlos', 'LopezOlivas', 'PostDoctorado', 'hacksFacebooks1234', '0');
INSERT INTO `mydb`.`Usuario` (`Usuario_Clase`, `Usuario_Nombre`, `Usuario_Apellidos`, `Usuario_Grado`, `Usuario_Password`, `Usuario_Activo`) VALUES ('administrador', 'paty', 'razo', 'coordinador', 'coordinador', '1');


INSERT INTO `mydb`.`Material` (`Material_Nombre`, `Material_Clase`, `Material_Existencia`, `Material_Disponible`, `Material_Habilidad`) VALUES ('the programming book', 'libro', '10', '10', 'lectura');
INSERT INTO `mydb`.`Material` (`Material_Nombre`, `Material_Clase`, `Material_Existencia`, `Material_Disponible`, `Material_Habilidad`) VALUES ('memorama', 'juego', '100', '100', 'lectua, escritura, audicion');
INSERT INTO `mydb`.`Material` (`Material_Nombre`, `Material_Clase`, `Material_Existencia`, `Material_Disponible`, `Material_Habilidad`) VALUES ('simon dice', 'juego', '12', '10', 'lectura, escritura');
INSERT INTO `mydb`.`Material` (`Material_Nombre`, `Material_Clase`, `Material_Existencia`, `Material_Disponible`, `Material_Habilidad`) VALUES ('scary movie 3', 'pelicula', '1', '1', 'audicion');
INSERT INTO `mydb`.`Material` (`Material_Nombre`, `Material_Clase`, `Material_Existencia`, `Material_Disponible`, `Material_Habilidad`) VALUES ('ruleta rusa', 'juego', '2', '1', 'lectura, escritura, audicion');


INSERT INTO `mydb`.`Juego` (`Juego_Idioma`, `Juego_EnlaceDigital`, `Juego_InstruccionesUso`, `Juego_Descripcion`, `Juego_MaterialAdicional`, `Juego_NumeroParticipantes`, `Juego_TiempoSugerido`, `Juego_EtiquetaTemas`, `Juego_EtiquetasVocabulario`, `Material_idMaterial`) VALUES ('ingles', '', 'ninguna instruccion', 'ninguna descripcion', 'ningun material adicional', '5', '15 minutos', 'pass, present,future', 'dress, cap, sport', '1');
INSERT INTO `mydb`.`Juego` (`Juego_Idioma`, `Juego_EnlaceDigital`, `Juego_InstruccionesUso`, `Juego_Descripcion`, `Juego_MaterialAdicional`, `Juego_NumeroParticipantes`, `Juego_TiempoSugerido`, `Juego_EtiquetaTemas`, `Juego_EtiquetasVocabulario`, `Material_idMaterial`) VALUES ('ingles', '', 'ninguna instraccuon', 'ninguna descripcion', 'ninguna material adicional', '2', '10 minutos', 'pass, present,future', 'small, big, tiny', '2');
INSERT INTO `mydb`.`Juego` (`Juego_Idioma`, `Juego_EnlaceDigital`, `Juego_InstruccionesUso`, `Juego_Descripcion`, `Juego_MaterialAdicional`, `Juego_NumeroParticipantes`, `Juego_TiempoSugerido`, `Juego_EtiquetaTemas`, `Juego_EtiquetasVocabulario`, `Material_idMaterial`) VALUES ('italiano', '', 'ninguna instruccion', 'ninguna descripcion', 'ningun material adicional', '10', '30 minutos', 'pass, present,future', 'gun, kill, shot', '4');

INSERT INTO `mydb`.`Administrador` (`Administrador_NivelIngles`, `Usuario_idUsuario`) VALUES ('10', '5');
INSERT INTO `mydb`.`Administrador` (`Administrador_NivelIngles`, `Usuario_idUsuario`) VALUES ('100', '1');

INSERT INTO `mydb`.`solicitud` (`Observaciones_Salida`, `Observaciones_Entrada`, `Fecha_Peticion`, `Fecha_Respuesta`, `Fecha_Terminacion`, `Profesor_IdProfesor`) VALUES ('no', 'no', '12-05-2010', '13-06-2010', '15-06-2010', '3');
INSERT INTO `mydb`.`solicitud` (`Observaciones_Salida`, `Observaciones_Entrada`, `Fecha_Peticion`, `Fecha_Respuesta`, `Fecha_Terminacion`, `Profesor_IdProfesor`) VALUES ('faltan cartas', 'cartas rotas', '02-03-2011', '04-03-2011', '05-05-2011', '3');
INSERT INTO `mydb`.`solicitud` (`Observaciones_Salida`, `Observaciones_Entrada`, `Fecha_Peticion`, `Fecha_Respuesta`, `Fecha_Terminacion`, `Profesor_IdProfesor`) VALUES ('no', 'no', '30-08-2011', '01-09-2011', '05-09-2011', '03');
INSERT INTO `mydb`.`solicitud` (`Observaciones_Salida`, `Observaciones_Entrada`, `Fecha_Peticion`, `Fecha_Respuesta`, `Fecha_Terminacion`, `Profesor_IdProfesor`) VALUES ('juego roto', 'faltan 10 fichas', '20-02-2012', '21-02-2012', '27-02-2012', '3');
