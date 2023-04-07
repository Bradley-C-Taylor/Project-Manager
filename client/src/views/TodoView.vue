<template>
  <div class="todo">
      <div class="section">
          <h2 class="heading">Project Sections</h2>
          <h2>API</h2>
          <h2>Client</h2>
          <h2>Database</h2>
      </div>
      <div class="pending">
        <h2 class="heading">Pending</h2>
      </div>
      <div class="in-progress">
          <h2 class="heading">In Progress</h2>
      </div>
      <div class="completed">
          <h2 class="heading">Completed</h2>
      </div>
  </div>
</template>

<script>
export default {
  name: 'TodoView'
}
</script>

<style scoped>
div.todo {
    height: 100%;
    display: flex;
    justify-content: space-between;
}
div.todo > div {
    width: 25rem;
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: var(--xtr-light-blue);
    border-radius: .5rem;
    border: 2px solid var(--dark-blue);
}
div.section {
    justify-content:space-around;
}
h2 {
    width: 20rem;
    padding: 2rem 0;
    border-radius: .75rem;
    background-color: var(--light-blue);
}
h2.heading {
    justify-self:start;
}

</style>
