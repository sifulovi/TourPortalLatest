<div class="form-group">
    <label><g:message code="tour.name"/> *</label>
    <g:textField name="title" class="form-control" value="${tour?.title}" placeholder="Please Enter Tour Title"/>
    <small id="emailHelp" class="form-text text-muted">Title should Be Unique</small>
    <UIHelper:renderErrorMessage fieldName="title" model="${tour}" errorMessage="Please Enter Valid Input "/>
</div>

<div class="form-group">
    <label><g:message code="from.date"/> *</label>
    <br>
    <g:datePicker name="fromDate" value="${tour?.fromDate}" />
    <UIHelper:renderErrorMessage fieldName="fromDate" model="${tour}" errorMessage="Please Enter Valid Input "/>
</div>

<div class="form-group">
    <label><g:message code="to.date"/> *</label>
    <br>
    <g:datePicker name="toDate" value="${tour?.toDate}"  />
    <UIHelper:renderErrorMessage fieldName="toDate" model="${tour}" errorMessage="Please Enter Valid Input "/>
</div>

<div class="form-group">
    <label><g:message code="tour.day"/> *</label>
    <g:textField name="day" class="form-control" value="${tour?.day}" placeholder="Please Enter Days"/>
    <UIHelper:renderErrorMessage fieldName="day" model="${tour}" errorMessage="Please Enter Day"/>
</div>

<div class="number-panel">
    <g:include controller="tourPackage" action="tourPackages" id="${tour?.id}"/>
</div>

<div class="form-group">
    <label><g:message code="tour.description"/> *</label>
    <g:textArea rows="5" cols="40" name="description" class="form-control" value="${tour?.description}"
                placeholder="Please Enter Description"/>

    <UIHelper:renderErrorMessage fieldName="description" model="${tour}" errorMessage="Please Enter Description"/>
</div>


<div class="form-group">
    <label><g:message code="booking.date"/> *</label>
    <br>
    <g:datePicker name="lastDate" value="${tour?.lastDate}"  />
    <UIHelper:renderErrorMessage fieldName="lastDate" model="${tour}" errorMessage="Please Enter Valid Input "/>
</div>

