<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="tour" args="['List Of']"/>
        <span class="float-right">

            <div class="btn-group">
                <g:link controller="tour" action="create" class="btn btn-success"><g:message code="create"/></g:link>
                <g:link controller="tour" action="index" class="btn btn-primary"><g:message code="reload"/></g:link>
            </div>
        </span>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
               <th>Name</th>
                <th >Amount</th>
                <th class="action-row"><g:message code="action"/></th>
            </tr>
            </thead>
            <tbody>
                <g:each in="${list}" var="info">
                    <tr>
                        <td>${info?.title}</td>
                        <td>${info?.tourPackage?.sum{it?.amount}}</td>
                        <td>
                            <div class="btn-group">
                                <g:link controller="tour" action="show" class="btn btn-secondary" id="${info.id}"><i class="fa fa-eye fa-lg"></i></g:link>
                                <g:link controller="tour" action="edit" class="btn btn-secondary" id="${info.id}"><i class="fa fa-pencil fa-lg"></i></g:link>
                                <g:link controller="tour" action="delete" id="${info.id}" class="btn btn-secondary delete-confirmation"><i class="fa fa-remove fa-lg"></i></g:link>
                            </div>
                        </td>
                    </tr>
                </g:each>
            </tbody>
        </table>
        <div class="paginate">
            <g:paginate total="${total ?: 0}" />
        </div>
    </div>
</div>