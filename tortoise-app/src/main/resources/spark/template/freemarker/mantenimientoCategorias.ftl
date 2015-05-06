<h1>Mantenimiento de Categorias</h1>
<a href="/Mantenimiento/Categorias/Registrar">Agregar nueva categoria</a>
<table>
    <tr>
        <th>ID</th>
        <th>Descripcion</th>
        <th>Accion</th>
    </tr>
        <#list categorias as categoria>
            <tr>
                <td>${categoria.identificador}</td>
                <td>${categoria.descripcion}</td>
                <td><a href="/Mantenimiento/Categorias/Actualizar/${categoria.identificador}">Editar</a>
                    |<a href="/Mantenimiento/Categorias/Eliminar/${categoria.identificador}">Eliminar</a></td>
            </tr>
        </#list>  
</table>