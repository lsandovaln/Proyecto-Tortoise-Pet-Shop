<h1>Mantenimiento de Productos</h1>
<a href="#">Agregar nuevo producto</a>
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
            <td>${producto.identificador}</td>
            <td>${producto.nombre}</td>
            <td>${producto.categoria.descripcion}</td>
            <td>${producto.precio}</td>
            <td>${producto.stock}</td>
            <td><td><a href="#">Editar</a></td><td><a href="#">Eliminar</a></td></td>
        </#list>  
</table>