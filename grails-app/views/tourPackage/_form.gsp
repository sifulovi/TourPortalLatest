<div class="form-group">
    <div class="form-inline phone-tourPackage-area">
        <g:if test="${tourPackage}">
            <g:hiddenField name="packageId" value="${tourPackage.id}"/>
        </g:if>
        <div class="form-group">
        <g:textField name="name" class="form-control" placeholder="Enter Service" value="${tourPackage?.name}"/>

    </div>
        <div class="form-group mx-sm-3">
            <g:textField name="amount" class="form-control" placeholder="Enter amount" value="${tourPackage?.amount}"/>
        </div>
        <g:if test="${tourPackage}">
            <button type="button" data-id="${tourPackage?.id}" class="btn btn-danger remove-tourPackages"><i class="fa  fa-remove fa-lg"></i></button>
        </g:if>
        <g:else>
            <button type="button" class="btn btn-primary add-new-tourPackages"><i class="fa  fa-plus-circle fa-lg"></i></button>
        </g:else>
    </div>
</div>
