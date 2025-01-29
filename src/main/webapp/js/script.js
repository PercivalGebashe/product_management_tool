let productCount = 0;
document.getElementById('productForm').addEventListener('submit', function(event) {
event.preventDefault();
productCount++;
const title = document.getElementById('title').value;
const quantity = document.getElementById('quantity').value;
const size = document.getElementById('size').value;
const image = document.getElementById('image').files[0];
const tableBody = document.getElementById('productTableBody');

if (image) {
    const reader = new FileReader();
    reader.onload = function(e) {
        const newRow = `<tr>
            <td>${productCount}</td>
            <td>${title}</td>
            <td>${quantity}</td>
            <td>${size}</td>
            <td>
                <img src="/image?id=${product.id}" width="50" height="50" />
            </td>
            <td>
                <button class="btn btn-sm btn-info">✏</button>
                <button class="btn btn-sm btn-danger">✖</button>
            </td>
        </tr>`;
        tableBody.innerHTML += newRow;
    };
    reader.readAsDataURL(image);
}
});