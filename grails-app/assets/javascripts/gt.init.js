/**
 * Created by touhid on 30/08/2015.
 */

jQuery(document).ready(function () {


    jQuery('.delete-confirmation').confirm({
        title: 'Delete Confirmation!',
        content: 'Are you sure want to delete?'
    });

    jQuery('.card-body').on('click', '.add-new-tourPackages ', function () {
        var _this = jQuery(this);
        GT.ajax.call({
            url: GT.baseURL + "tourPackage/tourPackages",
            dataType: "html",
            success: function (content) {
                jQuery('.number-panel').append(content);
                _this.removeClass("add-new-tourPackages");
                _this.removeClass("btn-primary");
                _this.addClass("remove-tourPackages");
                _this.addClass("btn-danger");
                _this.find(".fa").removeClass("fa-plus-circle");
                _this.find(".fa").addClass("fa-remove");
            }
        });
    });

    jQuery('.card-body').on('click', '.remove-tourPackages', function () {
        var _this = jQuery(this),
            tourPackageId = _this.attr("data-id");

        jQuery.confirm({
            title: 'Delete Confirmation!',
            content: 'Are you sure want to delete?',
            buttons: {
                confirm: {
                    text: 'Yes',
                    btnClass: 'btn-blue',
                    action: function () {
                        if(tourPackageId !== undefined){
                            GT.ajax.call({
                                url: GT.baseURL + "tourPackage/delete/" + tourPackageId,
                                success: function (content) {
                                    console.log(content);
                                    if(content.success === true){
                                        GT.messageBox.showMessage(true, content.info);
                                        _this.closest(".form-group").remove();
                                    }else{
                                        GT.messageBox.showMessage(false, content.info)
                                    }
                                }
                            });
                        }else{
                            _this.closest(".form-group").remove();
                        }
                    }
                },
                cancel: {
                    text: 'No'
                }
            }
        });

    });


});
