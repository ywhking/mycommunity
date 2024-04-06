import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import viteBasicSslPlugin from '@vitejs/plugin-basic-ssl'
import { copy } from 'vite-plugin-copy'
import { viteStaticCopy } from 'vite-plugin-static-copy'


// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    react(),
    viteBasicSslPlugin(),
    viteStaticCopy({
      targets: [
        {
          src: './src/*.json',
          dest: './'
        }
      ]
    })
  ],
})