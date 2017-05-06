INSERT INTO `mydb`.`Usuario` (`Usuario_Clase`, `Usuario_Nombre`, `Usuario_Apellidos`, `Usuario_Grado`, `Usuario_Password`, `Usuario_Activo`) VALUES ('administrador', 'isabel', 'rosa', 'maestria', '1234', '1');
INSERT INTO `mydb`.`Usuario` (`Usuario_Clase`, `Usuario_Nombre`, `Usuario_Apellidos`, `Usuario_Grado`, `Usuario_Password`, `Usuario_Activo`) VALUES ('EstudianteLei', 'raquel', 'zavala', 'estudiante', '5678', '');
INSERT INTO `mydb`.`Usuario` (`Usuario_Clase`, `Usuario_Nombre`, `Usuario_Apellidos`, `Usuario_Grado`, `Usuario_Password`, `Usuario_Activo`) VALUES ('profesor', 'rodolfo', 'garcia', 'profesor', '9101', '');
INSERT INTO `mydb`.`Usuario` (`Usuario_Clase`, `Usuario_Nombre`, `Usuario_Apellidos`, `Usuario_Grado`, `Usuario_Password`) VALUES ('EstudianteSimple', 'carlos', 'LopezOlivas', 'PostDoctorado', 'hacksFacebooks1234');
INSERT INTO `mydb`.`Usuario` (`idUsuario`, `Usuario_Clase`, `Usuario_Nombre`, `Usuario_Apellidos`, `Usuario_Grado`, `Usuario_Password`, `Usuario_Activo`) VALUES ('5', 'administrado', 'paty', 'razo', 'coordinador', 'coordinador', '1');




INSERT INTO `mydb`.`Material` (`idMaterial`, `Material_Nombre`, `Material_Clase`, `Material_Existencia`, `Material_Disponible`, `Material_Habilidad`) VALUES ('0', 'the programming book', 'libro', '10', '10', 'lectura');
INSERT INTO `mydb`.`Material` (`idMaterial`, `Material_Nombre`, `Material_Clase`, `Material_Existencia`, `Material_Disponible`, `Material_Habilidad`) VALUES ('1', 'memorama', 'juego', '100', '100', 'lectua, escritura, audicion');
INSERT INTO `mydb`.`Material` (`idMaterial`, `Material_Nombre`, `Material_Clase`, `Material_Existencia`, `Material_Disponible`, `Material_Habilidad`) VALUES ('2', 'simon dice', 'juego', '12', '10', 'lectura, escritura');
INSERT INTO `mydb`.`Material` (`idMaterial`, `Material_Nombre`, `Material_Clase`, `Material_Existencia`, `Material_Disponible`, `Material_Habilidad`) VALUES ('3', 'scary movie 3', 'pelicula', '1', '1', 'audicion');
INSERT INTO `mydb`.`Material` (`idMaterial`, `Material_Nombre`, `Material_Clase`, `Material_Existencia`, `Material_Disponible`, `Material_Habilidad`) VALUES ('4', 'ruleta rusa', 'juego', '2', '1', 'lectura, escritura, audicion');
INSERT INTO `mydb`.`Material` (`idMaterial`) VALUES ('5');



INSERT INTO `mydb`.`Juego` (`Juego_Idioma`, `Juego_EnlaceDigital`, `Juego_InstruccionesUso`, `Juego_Descripcion`, `Juego_MaterialAdicional`, `Juego_NumeroParticipantes`, `Juego_TiempoSugerido`, `Juego_EtiquetaTemas`, `Juego_EtiquetasVocabulario`, `Material_idMaterial`) VALUES ('ingles', '', 'ninguna instruccion', 'ninguna descripcion', 'ningun material adicional', '5', '15 minutos', 'pass, present, future', 'dress, cap, sport, technologies', '1');
INSERT INTO `mydb`.`Juego` (`Juego_Idioma`, `Juego_EnlaceDigital`, `Juego_InstruccionesUso`, `Juego_Descripcion`, `Juego_MaterialAdicional`, `Juego_NumeroParticipantes`, `Juego_TiempoSugerido`, `Juego_EtiquetaTemas`, `Juego_EtiquetasVocabulario`, `Material_idMaterial`) VALUES ('ingles', '', 'ninguna instraccuon', 'ninguna descripcion', 'ninguna material adicional', '2', '10 minutos', 'pass, present, future', 'small, big, tiny, great', '2');
INSERT INTO `mydb`.`Juego` (`Juego_Idioma`, `Juego_EnlaceDigital`, `Juego_InstruccionesUso`, `Juego_Descripcion`, `Juego_MaterialAdicional`, `Juego_NumeroParticipantes`, `Juego_TiempoSugerido`, `Juego_EtiquetaTemas`, `Juego_EtiquetasVocabulario`, `Material_idMaterial`) VALUES ('italiano', '', 'ninguna instruccion', 'ninguna descripcion', 'ningun material adicional', '10', '30 minutos', 'pass, present. future', 'gun, kill, shot, russian', '4');

INSERT INTO `mydb`.`Administrador` (`Administrador_NivelIngles`, `Usuario_idUsuario`) VALUES ('10', '5');
INSERT INTO `mydb`.`Administrador` (`Administrador_NivelIngles`, `Usuario_idUsuario`) VALUES ('100', '1');
