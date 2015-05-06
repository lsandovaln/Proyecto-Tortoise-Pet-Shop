<h1>
    <#if producto??>
        Editar producto
    <#else>
        Agregar nuevo producto
    </#if>
</h1>
<form method="POST" 
    <#if producto??>
        action="/Mantenimiento/Productos/Actualizar/:${producto.identificador}"
    <#else>
        action="/Mantenimiento/Productos/Registrar"
    </#if>>

    <table>
        <#if producto??>
            <tr>
                <th>ID</th>
                <td>
                    <input type="text" name="txtId" 
                        value="${producto.identificador}" readonly>
                </td>
            </tr>
        </#if>
        <tr>
            <th>Nombre</th>
            <td>
                <input type="text" name="txtNombre" 
                    value="<#if producto??>${producto.nombre}</#if>">
            </td>
        </tr>
        <tr>
            <th>Categoria</th>
            <td>
                <select name="txtCategoria" id="txtCategoria">
                    <#list categorias as categoria>
                        <option value="${categoria.identificador}">
                            ${categoria.descripcion}</option>
                    </#list>  
                </select>
            </td>
        </tr>
        <tr>
            <th>Precio</th>
            <td>
                <input type="text" name="txtPrecio" 
                    value="<#if producto??>${producto.precio}</#if>">
            </td>
        </tr>
        <tr>
            <th>Stock</th>
            <td>
                <input type="text" name="txtStock" 
                    value="<#if producto??>${producto.stock}</#if>">
            </td>
        </tr>
    </table>
    <input type="submit" value="Guardar">
</form>
<script>
    function setSelectValue (id, val) {
        document.getElementById(id).value = val;
    }
    <#if producto??>
        setSelectValue('txtCategoria', ${producto.categoria.identificador});
    <#else>
        <#list categorias as categoria>
            setSelectValue('txtCategoria', ${categoria.identificador});
            <#break>
        </#list>  
    </#if>
</script>