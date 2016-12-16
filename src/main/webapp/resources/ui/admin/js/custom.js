/*
 * Custom scripts used for DashBoard
 */

function deleteConfirm(targetUrl, name, type) {
	var deleteBtns = $(".deleteTarget");
	var deleteBtn = deleteBtns[0];

	var cancelBtns = $(".cancelBtn");
	var cancelBtn = cancelBtns[0];

	if(type) {
		$(".deleteMsg").text("Are you sure want to cancel?");
		deleteBtn.text = "Yes";
		cancelBtn.text = "No";
	}else {
		$(".deleteMsg").text("Are you sure want to delete?");
		deleteBtn.text = "Delete";
		cancelBtn.text = "Cancel";
	}
	$(".delName").text(name);
	$(".deleteTarget").attr("href", targetUrl);
	$("#deleteConfirm").modal('show');
}