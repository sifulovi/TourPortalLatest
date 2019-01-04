<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="tour" args="['List Of']"/>
    </div>
</div>

<div class="card-body">
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <g:sortableColumn property="name" title="${g.message(code: "name")}"/>
            <th>Email</th>
            <th>Phone No</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${list}" var="info">
            <tr>
                <td>${info?.firstName} ${info?.lastName}</td>
                <td>${info?.email}</td>
                <td>${info?.phoneNo}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
