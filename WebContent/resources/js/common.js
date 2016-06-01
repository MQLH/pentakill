/**
 * 通过fromId得到from中json数据
 * 
 * @param fromName
 *            from名称
 * @returns json对应的String
 */
function getFromJsonString(fromName) {
	var serializeJson = $("#" + fromName).serializeArray();
	return covertJsonArrayToString(serializeJson);
}

/**
 * 得到第一个from中的json数据
 * 
 * @returns json对应的String
 */
function getFromJsonString() {
	var serializeJson = $("form").eq(0).serializeArray();
	return covertJsonArrayToString(serializeJson);
}

/**
 * 将jsonArray转换为对应的json字符串
 * @param serializeJson jsonArray
 * @returns jsonString
 */
function covertJsonArrayToString(serializeJson) {
	var jsondata = {};
	$.each(serializeJson, function() {
		jsondata[this.name] = this.value;
	});
	var serialize = JSON.stringify(jsondata);
	return serialize;
}