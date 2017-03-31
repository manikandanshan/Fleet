'use strict';

assertManagementApp.factory('associateTypeService', function($http, $q){
    return {
    	
    	fetchAll: function() {
            return $http.get('http://localhost:8081/fleet-management/list/associate-type')
            .then(
                    function(response){
                    	console.log("response.data :- "+ response.data);
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while fetching ');
                        return $q.reject(errResponse);
                    }
            );
        },
   	
    	
    	
    	create: function(associateType){
            return $http.post('http://localhost:8081/fleet-management/new/associate-type',associateType )
            .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while creating associateType');
                        return $q.reject(errResponse);
                    }
            );
        }
    };
 /*
	var factory = {
	        fetchAll: fetchAll,
	        savePage: savePage,
	        update: update,
	        remove: remove
	    };

	    return factory;

	    function fetchAll() {
	        var deferred = $q.defer();
	        $http.get('http://localhost:8081/fleet-management/list/associate-type')
	            .then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error while fetching AssociateTypes');
	                deferred.reject(errResponse);
	            }
	        );
	        return deferred.promise;
	    }

	    function savePage(associateType) {
	        var deferred = $q.defer();
	        $http.post('http://localhost:8081/fleet-management/new/associate-type/+id')
	            .then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error while creating AssociateType');
	                deferred.reject(errResponse);
	            }
	        );
	        return deferred.promise;
	    }
*/});
