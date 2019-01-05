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
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${list}" var="info">
            <tr>
                <td>${info?.firstName} ${info?.lastName}</td>
                <td>${info?.email}</td>
                <td>${info?.phoneNo}</td>
                <td>
                    <div class="btn-group">
                        <g:link controller="authentication" action="deleteMember" id="${info.id}" class="btn btn-secondary delete-confirmation"><i class="fa fa-remove fa-lg"></i></g:link>
                    </div>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
