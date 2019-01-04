<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="tour" args="['List Of']"/>
    </div>
</div>


<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 mx-auto">
            <div class="row no-gutters my-3">
            %{--<tour>--}%
            %{--    <g:if test="${lastDate <= currentDate}">--}%
                    <g:each in="${list}" var="info">

                        <div class="col-md-3 pr-2 ">
                            <div class="list-group text-center my-3 ">
                                <div class="card mb-4 ovBorder ">
                                    <div class="card-header bg-primary text-white">
                                        <h4 class="my-0 font-weight-normal  ">${info?.title}</h4>
                                    </div>

                                    <div class="card-body ">
                                        <h1 class="card-title pricing-card-title">‎$${info?.tourPackage?.sum {
                                            it?.amount
                                        }}<small
                                                class="text-muted">/ ${info?.day}&nbsp;Days</small></h1>
                                        <ul class="list-unstyled mt-3 mb-4 topbar">
                                            <li><p><g:formatDate format="MMMM dd, yyyy"
                                                                 date="${info?.fromDate}"/></p>

                                                <p>To</p>

                                                <p><g:formatDate format="MMMM dd, yyyy"
                                                                 date="${info?.toDate}"/></p>

                                            </li>
                                            <li>Last Booking Date : <g:formatDate format="MMMM dd, yyyy"
                                                                                  date="${info?.lastDate}"/></li>
                                        </ul>
                                        <g:link controller="tour" action="show"
                                                class="btn btn-sm btn-block btn-info"
                                                id="${info.id}">More Info</g:link>

                                        <g:link controller="tourBooking" action="create" id="${info.id}"
                                                class="btn btn-sm btn-block btn-success ">Booking</g:link>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </g:each>
         %{--       </g:if>
                <g:else>
                  No data Found
                </g:else>--}%
            %{--</tour>--}%
            </div>
            <hr>
        </div>
    </div>
</div>

<style>
.ovBorder {
    border: none;
    border-radius: 1rem;
    transition: all 0.2s;
    box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
}

.topbar {
    display: block;
    overflow: hidden;
    height: 200px;
}
</style>