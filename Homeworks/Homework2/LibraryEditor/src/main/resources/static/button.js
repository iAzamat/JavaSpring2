function handleChange(bookId) {
    var bookName = document.querySelector('.name_change_' + bookId).value;
    if (bookName.trim() === '') {
        alert('Пожалуйста, введите название книги');
    } else {
        fetch('/api/books/update/' + bookId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name: bookName}),
        })
            .then(response => {
                location.reload();
            })
            .catch(error => {
                // обработка ошибки
            });
    }
}

function handleDelete(bookId) {
    fetch('/api/books/delete/' + bookId, {
        method: 'DELETE',
    })
        .then(response => {
            location.reload();
        })
        .catch(error => {
            // обработка ошибки
        });
}

function handleAdd() {
    var bookName = document.querySelector('.name_change_new').value;
    if (bookName.trim() === '') {
        alert('Пожалуйста, введите название книги');
    } else {
        fetch('/api/books/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name: bookName}),
        })
            .then(response => {
                location.reload();
            })
            .catch(error => {
                // обработка ошибки
            });
    }
}