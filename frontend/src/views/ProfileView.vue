<template>
  <section class="card">
    <h2>User Profile</h2>
    <div v-if="loading" class="hint">Loading user info...</div>
    <div v-else-if="user" class="profile">
      <div>
        <span>ID</span>
        <strong>{{ user.id }}</strong>
      </div>
      <div>
        <span>Username</span>
        <strong>{{ user.username }}</strong>
      </div>
      <div>
        <span>Email</span>
        <strong>{{ user.email }}</strong>
      </div>
    </div>
    <p v-else class="error">Unable to load user.</p>
    <div class="actions">
      <button @click="handleLogout">Logout</button>
    </div>
  </section>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import { fetchUser } from "../api";

const router = useRouter();
const loading = ref(true);
const user = ref(null);

async function loadUser() {
  const token = localStorage.getItem("demo-token");
  if (!token) {
    router.push("/login");
    return;
  }

  try {
    const cached = localStorage.getItem("demo-user");
    if (cached) {
      user.value = JSON.parse(cached);
    }
    const { data } = await fetchUser(token);
    user.value = data;
    localStorage.setItem("demo-user", JSON.stringify(data));
  } catch (err) {
    user.value = null;
  } finally {
    loading.value = false;
  }
}

function handleLogout() {
  localStorage.removeItem("demo-token");
  localStorage.removeItem("demo-user");
  router.push("/login");
}

onMounted(loadUser);
</script>
