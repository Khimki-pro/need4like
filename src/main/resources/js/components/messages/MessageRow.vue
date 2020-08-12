<template>
    <div :style="image" class="image">
      <v-card color="#F0F8FF">
        <v-card-text primary-title>
            <user-link
                :user="message.author"
                size="48"
            ></user-link>
            <div class="pt-3">
                {{ message.text }}
            </div>
        </v-card-text>
      <media v-if="message.link" :message="message"></media>
        <v-card-actions v-if="profile.id === message.author.id">
            <v-btn @click="edit" small>Edit</v-btn>
            <v-btn icon @click="del" small>
                <v-icon>{{ delete1 }}</v-icon>
            </v-btn>
        </v-card-actions>
        <comment-list
                :comments="message.comments"
                :message-id="message.id"
        ></comment-list>
      </v-card>
    </div>

</template>

<script>
    import { mapState, mapActions } from 'vuex'
    import Media from 'components/media/Media.vue'
    import CommentList from '../comment/CommentList.vue'
    import UserLink from 'components/UserLink.vue'
    import { mdiDelete } from '@mdi/js'

    export default {
        data() {
            return {
                delete1: mdiDelete,
                image: {backgroundImage: "url(https://i.pinimg.com/originals/db/d8/3c/dbd83c2de27de7d14e9eb04392994e25.jpg)"}
            }
        },
        props: ['message', 'editMessage'],
        components: {UserLink, CommentList, Media },
        computed: mapState(['profile']),
        methods: {
            ...mapActions(['removeMessageAction']),
            edit() {
                this.editMessage(this.message)
            },
            del() {
                this.removeMessageAction(this.message)
            }
        }
    }
</script>

<style>
    .image {
        padding: 40px 40px 30px 40px;
        background-color:#ffffff;
        background-repeat:repeat;
        background-attachment:fixed;
        background-position:top left;
    }
</style>