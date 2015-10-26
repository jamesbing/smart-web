angular.module('starter.services', ['ngResource'])

.factory('service', ['$resource',function($resource) {
      var sr=$resource('http://localhost:8080/smart/service/find/');

return {
  all: function() {
      var chats= sr.query();
    return chats;
  },
  remove: function(chat) {
    chats.splice(chats.indexOf(chat), 1);
  },
  get: function(chatId) {
      var ser =sr.get({id:chatId});
      return ser;
  }
};
}])
.factory('sendOrder',['$resource',function($resource) {
        var sender=$resource('http://localhost:8080/smart/service/sendOrder/');
        return {
            send: function(contact) {
                console.log(contact);
                sender.save(contact,function(res) {
                     console.log(res);
                });
            }
        };
    }])
