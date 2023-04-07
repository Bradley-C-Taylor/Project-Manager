<template>
  <div id="app">
    <nav class="nav-container">
      <h1><font-awesome-icon icon="fa-solid fa-bars" class="switch-project"/>Project Manager</h1>
      <ul class="nav-list">
        <li>
          <router-link :to="{name: 'home'}">
            <font-awesome-icon icon="fa-solid fa-house" class="home"/>
          </router-link>
        </li>
        <li>API</li>
        <li>Client</li>
        <li>Diagrams</li>
        <li><router-link :to="{name: 'todo'}">To-do</router-link></li>
        <li>Login</li>
      </ul>
    </nav>
    <router-view/>
  </div>
</template>

<script>

export default {

}
</script>

<style>
:root {
  --dark-blue: #2c3e50ea;
  --light-blue: rgb(191, 225, 255);
  --xtr-light-blue: #e0fbfc;
}

body, html{
  height: 100%;
  margin: 0;
}

#app {
  height: 100%;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: var(--dark-blue);
}

h1 {
  display: flex;
  align-items: center;
  gap: .5rem;
  padding: 0 3rem;
  font-size: 2rem;
}

nav.nav-container {
  display: flex;
  justify-content: space-between;
  background-color: var(--dark-blue);
  color: var(--light-blue);
}

ul.nav-list {
  list-style: none;
  display: flex;
  padding: 0 3rem;
  font-size: 1.5rem;
}
ul.nav-list li {
  display: flex;
  align-items: center;
  padding: 0 1.5rem;
  border-right: 3px solid;
}
ul.nav-list li:hover {
  cursor: pointer;
}
</style>
