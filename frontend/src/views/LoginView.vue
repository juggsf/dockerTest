<template>
  <section class="card">
    <h2>Login</h2>
    <p class="hint">Use demo / password</p>
    <form @submit.prevent="handleLogin" class="form">
      <label>
        <span>Username</span>
        <input v-model.trim="form.username" type="text" required />
      </label>
      <label>
        <span>Password</span>
        <input v-model.trim="form.password" type="password" required />
      </label>
      <button type="submit" :disabled="loading">
        {{ loading ? "Logging in..." : "Login" }}
      </button>
      <p v-if="error" class="error">{{ error }}</p>
    </form>
  </section>
</template>

<script setup>
import { reactive, ref } from "vue";
import { useRouter } from "vue-router";
import { login } from "../api";

const router = useRouter();
const form = reactive({
  username: "demo",
  password: "password"
});
const loading = ref(false);
const error = ref("");

async function handleLogin() {
  error.value = "";
  loading.value = true;
  try {
    const { data } = await login(form.username, form.password);
    localStorage.setItem("demo-token", data.token);
    localStorage.setItem("demo-user", JSON.stringify(data.user));
    router.push("/profile");
  } catch (err) {
    error.value = "Login failed. Check credentials.";
  } finally {
    loading.value = false;
  }
}
</script>
