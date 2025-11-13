const api = {
  users: '/api/users',
  posts: '/api/posts'
};

async function fetchJSON(url, opts = {}) {
  const res = await fetch(url, { headers: { 'Content-Type': 'application/json' }, ...opts });
  if (!res.ok) throw new Error(await res.text());
  return res.json();
}

// State
let users = [];

async function loadUsers() {
  // No endpoint de listado aún, así que inferimos desde IDs conocidos + semillas (1..10) comprobando existencia.
  // Para MVP: intentar leer usuarios 1..10 y agregarlos si existen.
  const found = [];
  for (let id = 1; id <= 10; id++) {
    try {
      const u = await fetchJSON(`${api.users}/${id}`);
      found.push(u);
    } catch (e) {
      // ignorar 404
    }
  }
  users = found;
  renderUsers();
  renderUserSelects();
}

function renderUsers() {
  const select = document.getElementById('active-user');
  select.innerHTML = '';
  users.forEach(u => {
    const opt = document.createElement('option');
    opt.value = u.id;
    opt.textContent = `${u.id} - ${u.nombre}`;
    select.appendChild(opt);
  });
  updateActiveUserInfo();
}

function renderUserSelects() {
  const postAuthor = document.getElementById('post-author');
  postAuthor.innerHTML = '';
  users.forEach(u => {
    const opt = document.createElement('option');
    opt.value = u.id;
    opt.textContent = `${u.nombre}`;
    postAuthor.appendChild(opt);
  });
}

function updateActiveUserInfo() {
  const activeId = document.getElementById('active-user').value;
  const info = document.getElementById('active-user-info');
  const u = users.find(x => String(x.id) === String(activeId));
  if (!u) { info.textContent = 'Sin usuario activo.'; return; }
  info.innerHTML = `<strong>${u.nombre}</strong> | XP: ${u.xp} | Nivel: ${u.level}`;
}

document.getElementById('active-user').addEventListener('change', updateActiveUserInfo);

async function loadPosts() {
  const data = await fetchJSON(api.posts);
  renderPosts(data);
}

function renderPosts(posts) {
  const container = document.getElementById('posts');
  container.innerHTML = '';
  posts.forEach(p => {
    const div = document.createElement('div');
    div.className = 'post';
    const author = users.find(u => u.id === p.authorId);
    const likes = p.likesCount || 0;
    div.innerHTML = `
      <div class="meta">Post #${p.id} • ${new Date(p.fechaCreacion).toLocaleString()}</div>
      <div><strong>${author ? author.nombre : '¿?'}</strong>: ${escapeHtml(p.content)}</div>
      <div class="flex" style="margin-top:.45rem">
        <span class="pill">Likes: <span>${likes}</span></span>
        <button class="like-btn" data-like="${p.id}">Like</button>
      </div>
    `;
    container.appendChild(div);
  });
  container.querySelectorAll('button[data-like]').forEach(btn => {
    btn.addEventListener('click', async () => {
      const postId = btn.getAttribute('data-like');
      const activeId = document.getElementById('active-user').value;
      try {
        await fetchJSON(`${api.posts}/${postId}/like`, {
          method: 'POST',
          body: JSON.stringify({ userId: Number(activeId) })
        });
        await refreshAll();
      } catch (e) {
        alert('Error al dar like: ' + e.message);
      }
    });
  });
}

function escapeHtml(str) {
  return str.replace(/[&<>"]/g, c => ({ '&':'&amp;','<':'&lt;','>':'&gt;','"':'&quot;' }[c]));
}

// Forms
document.getElementById('user-form').addEventListener('submit', async (e) => {
  e.preventDefault();
  const fd = new FormData(e.target);
  const payload = Object.fromEntries(fd.entries());
  try {
    await fetchJSON(api.users, { method: 'POST', body: JSON.stringify(payload) });
    e.target.reset();
    document.getElementById('user-error').textContent = '';
    await loadUsers();
  } catch (err) {
    document.getElementById('user-error').textContent = 'Error: ' + err.message;
  }
});

document.getElementById('post-form').addEventListener('submit', async (e) => {
  e.preventDefault();
  const fd = new FormData(e.target);
  const payload = Object.fromEntries(fd.entries());
  payload.authorId = Number(payload.authorId);
  try {
    await fetchJSON(api.posts, { method: 'POST', body: JSON.stringify(payload) });
    e.target.reset();
    document.getElementById('post-error').textContent = '';
    await loadPosts();
    await loadUsers(); // XP cambió
  } catch (err) {
    document.getElementById('post-error').textContent = 'Error: ' + err.message;
  }
});

async function refreshAll() {
  await loadUsers();
  await loadPosts();
}

// Init
(async () => {
  await refreshAll();
})();
