<template>
  <div id="app">
    <nav class="nav-container">
      <h1>Project Manager</h1>
      <ul class="nav-list">
        <li>API</li>
        <li>Client</li>
        <li>Diagrams</li>
        <li>To-Do</li>
        <li>Login</li>
      </ul>
    </nav>
    <router-view/>
  </div>
</template>

<style>
body{
  height: 100%;
  margin: 0;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

h1 {
  display: flex;
  align-items: center;
  padding: 0 3rem;
  font-size: 2rem;
}

nav.nav-container {
  display: flex;
  justify-content: space-between;
  background-color: #2c3e50;
  color: rgb(191, 225, 255);
}

ul.nav-list {
  list-style: none;
  display: flex;
  padding: 0 3rem;
  font-size: 2rem;
}
ul.nav-list li {
  padding: 0 1.5rem;
  border-right: 3px solid;
}
</style>
