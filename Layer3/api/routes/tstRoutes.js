'use strict';
module.exports = function(app) {
var controller = require('../controllers/tstController');
app.route('/indices')
	.get(controller.list_all_indices);
app.route('/indices/:indexID/:recordID')
	.get(controller.read_a_record);
	// temperature
app.route('/temperatures')
	.get(controller.list_values);

};
