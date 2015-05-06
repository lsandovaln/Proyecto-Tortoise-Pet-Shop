<h1>Mantenimiento de Productos</h1>
<a href="/Mantenimiento/Productos/Registrar">Agregar nuevo producto</a>
<table>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Categoria</th>
        <th>Precio</th>
        <th>Stock</th>
        <th>Accion</th>
    </tr>
        <#list productos as producto>
            <tr>
                <td>${producto.identificador}</td>
                <td>${producto.nombre}</td>
                <td>${producto.categoria.descripcion}</td>
                <td>${producto.precio}</td>
                <td>${producto.stock}</td>
                <td><a href="/Mantenimiento/Productos/Actualizar/${producto.identificador}">Editar</a>
                    |<a href="/Mantenimiento/Productos/Eliminar/${producto.identificador}">Eliminar</a></td>
            </tr>
        </#list>  
</table>