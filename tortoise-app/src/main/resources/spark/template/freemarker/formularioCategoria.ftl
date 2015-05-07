<h1>
    <#if categoria??>
        Editar categoria
    <#else>
        Agregar nueva categoria
    </#if>
</h1>
<form method="POST" <#if categoria??>action="/Mantenimiento/Categorias/Actualizar/${categoria.identificador}"<#else>action="/Mantenimiento/Categorias/Registrar"</#if>>
    <table>
        <#if categoria??>
        <tr>
            <th>ID</th>
            <td>
                <input type="text" name="txtId" value="${categoria.identificador}" readonly>
            </td>
        </tr>
        </#if>
        <tr>
            <th>Descripcion</th>
            <td>
                <input type="text" name="txtDescripcion" id="txtDescripcion" value="<#if categoria??>${categoria.descripcion}</#if>">
            </td>
        </tr>
    </table>
    <input type="submit" value="Guardar">
</form>