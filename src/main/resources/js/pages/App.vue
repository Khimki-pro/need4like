<template>
    <v-app>
        <v-app-bar app color="indigo" dark>
            <v-toolbar-title> Need4Share&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </v-toolbar-title>
            <v-btn
                   v-if="profile"
                   :disabled="$route.path === '/'"
                   @click="showMessages">
                Messages
            </v-btn>
            <v-spacer></v-spacer>
            <v-btn
                   v-if="profile"
                   :disabled="$route.path === '/user'"
                   @click="showProfile">
                {{profile.name}}
            </v-btn>
            <v-btn v-if="profile" icon href="/logout">
                <v-icon>{{ logout }}</v-icon>
            </v-btn>
        </v-app-bar>
        <div :style="image" class="image">
            <v-content>
            <v-card v-if="profile"
                class="spacing-playground py-1 px-1"
                color="#F0F8FF"
                width=auto
            >
                <v-card-text>
                    <router-link
                        :to="`/user/106167075684989155972`">
                        <v-avatar>
                            <img
                            :src="`https://lh3.googleusercontent.com/a-/AOh14GhcLWtPuBNxlW0CH3sJDfo43X5lVKuvijo0k8hrog`"
                            :alt="`Вадим Шох`"
                            >
                        </v-avatar>
                        <span> Автор сайта </span>
                    </router-link>
                    <span> &nbsp&nbsp&nbspЭто Need4Share, уютный и быстрый онлайн-дневник.
                    <br>
                    Просто попробуйте (=^ ◡ ^=) Вам понравится!
                    <br>
                    Хорошего дня!
                    </span>
                </v-card-text>
            </v-card>
            <router-view></router-view>
            </v-content>
        </div>
    </v-app>
</template>

<script>
    import { mapState, mapMutations } from 'vuex'
    import { addHandler } from 'util/ws'
    import { mdiExitToApp } from '@mdi/js'
    import UserLink from 'components/UserLink.vue'

    export default {
        data() {
            return {
                logout: mdiExitToApp,
                image: {backgroundImage: "url(https://i.pinimg.com/originals/db/d8/3c/dbd83c2de27de7d14e9eb04392994e25.jpg)"}
            }
        },
        components: { UserLink },
        computed: mapState(['profile']),
        methods: {
            ...mapMutations([
                'addMessageMutation',
                'updateMessageMutation',
                'removeMessageMutation',
                'addCommentMutation'
            ]),
            showMessages() {
                this.$router.push('/')
            },
            showProfile() {
                this.$router.push('/user')
            }
        },
        created() {
            addHandler(data => {
                if (data.objectType === 'MESSAGE') {
                    switch (data.eventType) {
                        case 'CREATE':
                            this.addMessageMutation(data.body)
                            break
                        case 'UPDATE':
                            this.updateMessageMutation(data.body)
                            break
                        case 'REMOVE':
                            this.removeMessageMutation(data.body)
                            break
                        default:
                            console.error(`Looks like the event type if unknown "${data.eventType}"`)
                    }
                } else if (data.objectType === 'COMMENT') {
                    switch (data.eventType) {
                        case 'CREATE':
                            this.addCommentMutation(data.body)
                            break
                        default:
                            console.error(`Looks like the event type if unknown "${data.eventType}"`)
                    }
                } else {
                    console.error(`Looks like the object type if unknown "${data.objectType}"`)
                }
            })
        },
        beforeMount() {
            if (!this.profile) {
                this.$router.replace('/auth')
            }
        }
    }
</script>

<style>

</style>