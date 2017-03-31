'use strict';

assertManagementApp.controller('associateTypeController', function($scope,
		$log, $http, associateTypeService) {
	this.associateType = {
		id :null,
		code : '',
		name : '',
		staus : '',
		createdOn : '',
		createdBy : '',
		modifiedOn : ''
	};
	this.associateTypes=[];

	$scope.sample = "This is AMP App";

/*	this.fetchAll = function(){
		associateTypeService.fetchAll()
            .then(
                         function(d) {
                              this.associateTypes = d;
                         },
                          function(errResponse){
                              console.error('Error while fetching');
                          }
                 );
    };
	
	this.create = function(associateType){
		associateTypeService.create(associateType)
                .then(
                this.fetchAll, 
                        function(errResponse){
                             console.error('Error while creating associateType.');
                        } 
            );
    };
   
	$scope.checkAll = function () {
        if ($scope.selectedAll) {
            $scope.selectedAll = true;
        } else {
            $scope.selectedAll = false;
        }
        angular.forEach(this.associateTypes, function (associateType) {
        	associateType.Selected = $scope.selectedAll;
        });

    };

*/   

	console.log("@@@@ associateType @@@@@ :- " + associateType);
});
