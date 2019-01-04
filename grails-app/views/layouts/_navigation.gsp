<nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">
    <ul class="list-group">
        <g:if test="${user?.role == "ROLE_ADMIN"}">
        <UIHelper:appAdmin/>
        </g:if>
        <g:elseif test="${user?.role == "ROLE_MEMBER"}">
            <UIHelper:appMember/>
        </g:elseif>

    </ul>
</nav>