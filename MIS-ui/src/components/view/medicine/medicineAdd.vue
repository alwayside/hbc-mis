<template>
  <div class="hello" style="">
    <v-parallax
      height="120"
      :src="bgSrc"
    >
      <div class="carouselSpan mb-2">
        <span class="display-1" style="width: 50%">{{ $t('medicineSystem')}}</span>
      </div>
      <div class="carouselSpan1 ma-2">
        <span class="subtitle-1" style="width: 66%">{{$t('medicineSystemMsg')}}</span>
      </div>
    </v-parallax>
    <v-card elevation="0">
<!--      <v-card-title class="justify-center">-->
<!--      </v-card-title>-->
      <v-card-text>
        <v-row>
        <v-col>
          <v-snackbar v-model="successAlter" color="success">
              success
              <v-btn dark text @click="successAlter = false">{{$t('close')}}</v-btn>
            </v-snackbar>
             <v-snackbar v-model="errorAlter" color="error">
              error
              <v-btn dark text @click="errorAlter = false">{{$t('close')}}</v-btn>
            </v-snackbar>
    </v-col>
        </v-row>
        <v-row>
          <v-col sm="1"></v-col>
          <v-col>

            <span class="title">{{$t('medicineAdd')}}</span>
          </v-col>
          <v-col sm="1"></v-col>
        </v-row>
        <v-row><v-col sm="1"></v-col>
          <v-col>
              <v-text-field
                v-model="medicineName"
                :label="$t('medicineName')"
              />
          </v-col>
          <v-col sm="1"></v-col>
            <v-col>
              <v-text-field
                v-model="producer"
                :label="$t('producer')"
              />
            </v-col><v-col sm="1"></v-col>

        </v-row>
        <v-row><v-col sm="1"></v-col>
          <v-col>
            <v-text-field
              type="number"
              v-model="medicinePrice"
              :label="$t('Price')"
            />
          </v-col>
          <v-col sm="1"></v-col>
          <v-col>
            <v-text-field
              v-model="medicineUnit"
              :label="$t('Unit')"
            />
          </v-col><v-col sm="1"></v-col>
        </v-row>
        <v-row>
          <v-col sm="1"></v-col>
          <v-col>
            <v-textarea
              class="mx-2"
              :label="$t('Description')"
              rows="2"
              prepend-icon="comment"
              v-model="medicineDescription"
            ></v-textarea>
          </v-col>
          <v-col sm="1"></v-col>
        </v-row>
        <v-row>
          <v-col sm=5></v-col>
          <v-col sm="1">
            <v-btn color='success' block dark @click=getDate() class="mb-1">{{$t('add')}}</v-btn>
          </v-col>
          <v-col sm="1">
            <v-btn @click="$router.back(-1)"  block color='success' dark >
              {{$t('return')}}
            </v-btn>
          </v-col >
          <v-col sm="5"></v-col>
        </v-row>
      </v-card-text>
    </v-card>

    </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data: () => ({
    bgSrc: window.localStorage.getItem('bgPic'),
    msg: 'Welcome to Your Vue.js App',
    producer: '',
    medicineName: '',
    medicinePrice: '',
    medicineUnit: '',
    medicineDescription: '',
    successAlter: false,
    errorAlter: false
  }),
  methods: {
    getDate () {
      this.successAlter = false
      this.errorAlter = false
      let medicineDo = {
        medicineProducer: this.producer,
        medicineName: this.medicineName,
        medicinePrice: this.medicinePrice,
        medicineUnit: this.medicineUnit,
        medicineDescription: this.medicineDescription
      }
      let url = '/Medicine/add'
      this.$axios.put(url, medicineDo).then((res) => {
        if (res.status === 200) {
          this.producer = ''
          this.medicineName = ''
          this.medicinePrice = ''
          this.medicineUnit = ''
          this.medicineDescription = ''
          this.successAlter = true
        }
      }).catch((err) => {
        if (err) {
          this.errorAlter = true
        }
      })
    }
  },
  computed: {
    area () {
      return this.$i18n.locale
    }
  },
  created () {
    window.localStorage.setItem(
      'btnColor',
      [
        '#4caf50',
        'transparent',
        'transparent',
        'transparent',
        'transparent',
        'transparent'
      ])
  },
  mounted: function () {
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
