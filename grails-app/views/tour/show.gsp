<meta name="layout" content="main"/>


<div class="container-fluid">
    <div class="col-md-12  justify-content-center">
        <div class="card flex-md-row mb-4 box-shadow h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
                <h3 class="mb-0">
                    <a class="text-dark" href="#">${list?.title}</a>
                </h3>

                <div class="mb-1 text-muted"><g:formatDate format="MMMM dd, yyyy"
                                                           date="${list?.dateCreated}"/> Created by  ${list?.member?.lastName}</div>

                <p class="card-text mb-auto">${list?.description}</p>
                <ul>
                    <li><strong>From Date :</strong><g:formatDate format="MMMM dd, yyyy"
                                                                  date="${list?.fromDate}"/> Days</li>
                    <li><strong>To Date :</strong><g:formatDate format="MMMM dd, yyyy"
                                                                date="${list?.toDate}"/> Days</li>
                    <li><strong>Days :</strong>${list?.day} Days</li>

                </ul>

            </div>
            <g:img dir="images" file="bangladesh.jpg" class="card-img-top item"/>
        </div>
        <table class="table table-bordered">
            <h3 class="mb-4 ml-4">
                <a class="text-dark" href="#">Available Services</a>
            </h3>
            <thead class="thead-light">
            <tr>

                <th>Name</th>
                <th>Amount</th>

            </tr>
            </thead>
            <tbody>
            <g:each in="${list?.tourPackage}" var="packages">
                <tr>
                    <td>${packages?.name}</td>
                    <td>${packages?.amount}</td>
                </tr>
            </g:each>
            </tbody>
            <tfoot>
            <tr class="text-primary">
                <td>Total Amount</td>
                <th   colspan="1">${list?.tourPackage?.sum{it?.amount}}</th>
            </tr>
            </tfoot>
        </table>
    </div>
</div>
<style>
.item {
    width: 500px;
    height: 300px;
}
</style>




