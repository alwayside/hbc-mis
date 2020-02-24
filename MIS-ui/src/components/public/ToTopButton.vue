<template>
  <v-fab-transition>
    <v-btn
      key="keyboard_arrow_up"
      color="success"
      fab
      large
      dark
      bottom
      right
      fixed
      class="v-btn--example"
      style="z-index: 70"
      @click.native="scrollToTop"
      v-show="scrollHeight"
    >
      <v-icon>keyboard_arrow_up</v-icon>
    </v-btn>
  </v-fab-transition>
</template>

<script>
export default {
  name: 'ToTopButton',
  data: () => ({
    scrollHeight: ''
  }),
  methods: {
    scrollToTop: function () {
      scroll({
        behavior: 'smooth',
        left: 0,
        top: 0
      })
    },
    handleScroll: function () {
      this.scrollHeight = document.documentElement.scrollTop > 50
    },
    setScrollHeight: function () {
      this.scrollHeight = false
    }
  },
  computed: {
  },
  watch: {
  },
  mounted () {
    this.setScrollHeight()
  },
  created () {
    window.addEventListener('scroll', this.handleScroll)
  }
}
</script>

<style scoped>

</style>
