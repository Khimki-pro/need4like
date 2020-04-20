<template>
    <v-card class="my-2">
    <v-card-text primary-title>
        <i>({{ message.id }})</i>
        {{ message.text }}
    </v-card-text>
        <v-card-actions>
            <v-btn @click="edit" small>Edit</v-btn>
            <v-btn icon @click="del" small>
                <v-icon>{{ delete1 }}</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
    import { mdiDelete } from '@mdi/js'

    export default {
        data() {
            return {
                delete1: mdiDelete
            }
        },
        props: ['message', 'editMessage', 'deleteMessage', 'messages'],
            methods: {
                edit() {
                    this.editMessage(this.message)
                },
                del() {
                    this.deleteMessage(this.message)
                }
            }
        }
</script>

<style>

</style>