function openEditModal(id, title, quantity, size) {
    // Populate modal fields with the current product data
    document.getElementById("productId").value = id;
    document.getElementById("modalTitle").value = title;
    document.getElementById("modalQuantity").value = quantity;
    document.getElementById("modalSize").value = size;

    // Show the modal using Bootstrap's modal function
    var myModal = new bootstrap.Modal(document.getElementById('editModal'), {
        keyboard: false
    });
    myModal.show();
}
