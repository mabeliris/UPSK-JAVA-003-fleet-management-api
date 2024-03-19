## <1.0.1> - <2024-03-19>

### Sprint learnings

- Aprendí a usar un Query nativo para un endpoint que trae las ultimas ubicaciones de cada Taxi
- Aprendí convertir un objeto List en un Page


### Added

- Agregué  test para algunas funcionalidades de trajectories en el controlador y el repositorio

### Changed

- Convertí el método para las últimas ubicaciones de Lista a Page
- Los cambios se realizaron el controlador, servicio y repositorio

### Fixed

- Se solucionó el error status 500 Internal Server Error, que ocurría al ejecutar la consulta 
  de las últimas ubicaciones de cada taxi en Swagger

### Removed

- Elimniné las anotaciones @column de la entidad trajectories 


## <1.0.0> - <2024-03-05>

### Sprint learnings

- Aprendí a hacer un endpoint con método get para listar elementos de una base de datos
- Aprendí a filtrar los archivos por ID y fecha

### Added

- se agregan endpoint para listar taxis y trayectorias
- se agrega endpoint para historial de ubicaciones filtrado por fecha y ID
- se agrega paginación para cada solicitud
- Se agrega documentación en Swagger

