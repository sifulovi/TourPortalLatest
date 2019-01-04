<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="tour.member" args="['List Of ']"/>
        <span class="float-right">

            <div class="btn-group">
                <g:link controller="dashboard" action="bookedTourList" class="btn btn-primary"><g:message code="reload"/></g:link>
            </div>
        </span>
    </div>

    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Member</th>
                <th>Tour List</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${list}" var="info">
                <tr>
                    <td>${info?.getKey()}</td>
                    <td>
                        <table class="table table-bordered">
                            <thead  class="thead-light">
                            <tr >
                                <th style="width: 50%">Tour Name</th>
                                <th>Booking Date</th>
                            </tr>
                            </thead>
                            <tbody>
                            <g:each in="${info?.getValue()}" var="tour" status="i">
                                <tr>
                                    <td>(${i + 1}) ${tour?.tour}</td>
                                    <td><g:formatDate format="MMMM dd, yyyy"
                                                      date="${tour?.dateCreated}"/></td>
                                </tr>
                            </g:each>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>