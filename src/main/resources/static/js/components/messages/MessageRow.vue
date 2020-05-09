<template>
    <v-card class="my-2">
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
        <v-card-actions>
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
</template>

<script>
    import { mapActions } from 'vuex'
    import Media from 'components/media/Media.vue'
    import CommentList from '../comment/CommentList.vue'
    import UserLink from 'components/UserLink.vue'
    import { mdiDelete } from '@mdi/js'

    export default {
        data() {
            return {
                delete1: mdiDelete
            }
        },
        props: ['message', 'editMessage'],
        components: {UserLink, CommentList, Media },
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

</style>