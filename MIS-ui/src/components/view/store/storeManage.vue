<template>
  <div class="hello" style>
    <v-parallax height="120" :src="bgSrc">
      <div class="carouselSpan mb-2">
        <span class="display-1" style="width: 50%">{{ $t('storeSystem')}}</span>
      </div>
      <div class="carouselSpan1 ma-2">
        <span class="subtitle-1" style="width: 66%">{{$t('storeSystemMsg')}}</span>
      </div>
    </v-parallax>
    <v-card elevation="0">
      <!--      <v-card-title class="justify-center">-->
      <!--      </v-card-title>-->
      <v-card-text>
        <v-row>
          <v-col sm="1"></v-col>
          <v-col class="d-flex justify start">
            <v-btn to="/store/add"  color="success">
                {{$t('storeAdd')}}
            </v-btn>
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
            <v-data-table :headers="headers" :items="items" item-key="id" class="elevation-1">
              <template v-slot:item.action="{ item }">
                <v-icon small class="mr-2" @click="edit(item)">edit</v-icon>
                <v-icon small @click="deleteItem(item)">delete</v-icon>
              </template>
            </v-data-table>
          </v-col>
          <v-col sm="1"></v-col>
        </v-row>
        <v-row>
          <v-col sm="1"></v-col>
          <v-col>
            <v-btn to="/store" block color="success" dark>{{$t('return')}}</v-btn>
          </v-col>
          <v-col sm="1"></v-col>
        </v-row>
        <v-dialog v-model="dialog" max-width="500px">
          <v-card>
            <v-card-title>
              <span class="headline">{{$t('editRecord')}}</span>
            </v-card-title>
            <v-card-text>
              <v-container>
                <v-row>
                  <v-col sm="6">
                    <v-text-field
                      :label="$t('storeName')"
                      v-model="editItem.storeName"
                    ></v-text-field>
                  </v-col>
                  <v-col sm="6">
                    <v-text-field
                      :label="$t('storeAddress')"
                      v-model="editItem.storeAddress"
                    ></v-text-field>
                  </v-col>
                  <v-col sm="6">
                    <v-text-field
                      :label="$t('storeCapacity')"
                      v-model="editItem.storeCapacity"
                      type="number"
                    ></v-text-field>
                  </v-col>
                  <v-col sm="6">
                    <v-text-field
                      :label="$t('storeCapacityUse')"
                      v-model="editItem.storeCapacityUse"
                      disabled
                      type="number"
                    ></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="close">{{$t('close')}}</v-btn>
              <v-btn color="blue darken-1" text @click="save">{{$t('save')}}</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <v-dialog v-model="dialog2" max-width="500px">
          <v-card>
            <v-card-title>
              <span class="headline">{{$t('deleteConfirm')}}</span>
            </v-card-title>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="close2">{{$t('close')}}</v-btn>
              <v-btn color="blue darken-1" text @click="deleteRecord">{{$t('delete')}}</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
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
    dialog: false,
    dialog2: false,
    editItem: {
      id: 0,
      storeName: '',
      storeAddress: '',
      storeCapacity: 0,
      storeCapacityUse: 0,
      isDelete: 0
    },
    deleteRecordItem: {
      id: 0,
      storeName: '',
      storeAddress: '',
      storeCapacity: 0,
      storeCapacityUse: 0,
      isDelete: 0
    },
    headers: [],
    items: [],
    successAlter: false,
    errorAlter: false
  }),
  methods: {
    setHeaders () {
      this.headers = [
        { text: this.$t('storeName'), value: 'storeName' },
        { text: this.$t('storeAddress'), value: 'storeAddress' },
        { text: this.$t('storeCapacity'), value: 'storeCapacity' },
        { text: this.$t('storeCapacityUse'), value: 'storeCapacityUse' },
        { text: this.$t('action'), value: 'action', sortable: false }
      ]
    },

    getDate () {
      let url = '/Store/all'
      this.$axios.get(url).then(res => {
        if (res.status === 200) {
          this.items = res.data
        }
      })
    },
    edit (item) {
      this.editItem = Object.assign({}, item)
      this.dialog = true
    },

    deleteItem (item) {
      this.deleteRecordItem = Object.assign({}, item)
      this.dialog2 = true
    },

    save () {
      let storeDo = this.editItem
      let url = '/Store/update'
      this.$axios
        .post(url, storeDo)
        .then(res => {
          if (res.status === 200) {
            this.successAlter = true
            this.getDate()
          }
        })
        .catch(err => {
          if (err) {
            this.errorAlter = true
          }
        })
      this.close()
    },

    deleteRecord () {
      let storeDo = this.deleteRecordItem
      let url = '/Store/delete'
      this.$axios
        .delete(url, { data: storeDo })
        .then(res => {
          if (res.status === 200) {
            this.successAlter = true
            this.getDate()
          }
        })
        .catch(err => {
          if (err) {
            this.errorAlter = true
          }
        })
      this.close2()
    },

    close () {
      this.editItem = {
        id: 0,
        storeName: '',
        storeAddress: '',
        storeCapacity: 0,
        storeCapacityUse: 0,
        isDelete: 0
      }
      this.dialog = false
    },

    close2 () {
      this.deleteRecordItem = {
        id: 0,
        storeName: '',
        storeAddress: '',
        storeCapacity: 0,
        storeCapacityUse: 0,
        isDelete: 0
      }
      this.dialog2 = false
    }
  },
  computed: {
    area () {
      return this.$i18n.locale
    }
  },
  created () {
    window.localStorage.setItem('btnColor', [
      'transparent',
      'transparent',
      'transparent',
      '#4caf50',
      'transparent',
      'transparent'
    ])
  },
  mounted: function () {
    this.setHeaders()
    this.getDate()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
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
